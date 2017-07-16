//
//  ItemsTableViewController.m
//  FoodTracker
//
//  Created by Viktoriia Vovk on 7/11/17.
//  Copyright © 2017 Viktoriia Vovk. All rights reserved.
//

#import "ItemsTableViewController.h"
#import "InputViewController.h"

@interface ItemsTableViewController ()
@property (nonatomic, strong) NSMutableArray *items;

@property (strong, nonatomic) IBOutlet UITableView *itemTableView;

@end

@implementation ItemsTableViewController

- (void)viewDidLoad {
    [super viewDidLoad];
//    [[self navigationController] setNavigationBarHidden:false animated:YES];
//    self.navigationController.title = @"TITLE";
    
    [self pullItems];
    
}

- (void)pullItems {
    NSString * path = @"http://localhost:8181/";
    NSMutableURLRequest *urlRequest = [[NSMutableURLRequest alloc] initWithURL:[NSURL URLWithString:path]];
    [urlRequest setHTTPMethod:@"GET"];
    
    NSURLSession *session = [NSURLSession sharedSession];
    NSURLSessionDataTask *dataTask = [session dataTaskWithRequest:urlRequest
                                                completionHandler:^(NSData *data,
                                                                    NSURLResponse *response,
                                                                    NSError *error) {
        NSHTTPURLResponse *httpResponse = (NSHTTPURLResponse *)response;
        if(httpResponse.statusCode == 200)
        {
            NSError *parseError = nil;
            _items = [NSJSONSerialization JSONObjectWithData:data
                                                     options:0
                                                       error:&parseError];
            NSLog(@"The response is - %@",_items);
            [_itemTableView reloadData];
        } else {
            NSLog(@"Error   %ld ", (long)httpResponse.statusCode);
        }
    }];
    [dataTask resume];
    
}


#pragma mark - Table view data source

- (void)tableView:(UITableView *)tableView
didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    InputViewController * detailVC = [self.storyboard instantiateViewControllerWithIdentifier:@"DetailVC"];
    detailVC.foodName = _items[indexPath.row];
    
    [self.navigationController pushViewController:detailVC
                                         animated:YES];
}


- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    return [_items count];
}


- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:@"ItemCell" forIndexPath:indexPath];
    
    cell.textLabel.text = [NSString stringWithFormat:@"%@", _items[indexPath.row]];
    return cell;
}


- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
}

@end
