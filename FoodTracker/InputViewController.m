//
//  InputViewController.m
//  FoodTracker
//
//  Created by Viktoriia Vovk on 7/11/17.
//  Copyright © 2017 Viktoriia Vovk. All rights reserved.
//

#import "InputViewController.h"

@interface InputViewController () <UITextFieldDelegate>
@property (weak, nonatomic) IBOutlet UITextField *inputTextField;
@property (weak, nonatomic) IBOutlet UIButton *pushButton;
@property (weak, nonatomic) IBOutlet UILabel *unswerLabel;
@property (nonatomic, strong) NSString *callories;

@end

@implementation InputViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    [self setup];
}

- (void)setup {
    self.inputTextField.delegate = self;
    self.inputTextField.placeholder = @"weight";
    
    [self.pushButton setTitle:@"Result" forState:UIControlStateNormal];
    
    self.unswerLabel.text = [NSString stringWithFormat:@"Please write weight for %@", _foodName];
}

- (BOOL) textFieldShouldReturn:(UITextField *)textField
{
    //    [self submitAction:nil];
    NSLog(@"input = %@", textField.text);
    return YES;
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
}

- (IBAction)onPushButtonTap:(id)sender {
    
    if (self.inputTextField.text)
    {
//        NSString *callories = @"";
        
        NSString *path = [NSString stringWithFormat:@"http://localhost:8181/getCallories?name=%@&weight=%@", _foodName, self.inputTextField.text];
        NSLog(@"%@", path);
        NSMutableURLRequest *urlRequest = [[NSMutableURLRequest alloc] initWithURL:[NSURL URLWithString:path]];
        NSLog(@"%@", urlRequest);
        [urlRequest setHTTPMethod:@"GET"];
        
        NSURLSession *session = [NSURLSession sharedSession];
        NSURLSessionDataTask *dataTask = [session dataTaskWithRequest:urlRequest completionHandler:^(NSData *data, NSURLResponse *response, NSError *error) {
            NSHTTPURLResponse *httpResponse = (NSHTTPURLResponse *)response;
            if(httpResponse.statusCode == 200)
            {
                NSError *parseError = nil;
                
                _callories = [NSJSONSerialization JSONObjectWithData:data
                                                                      options:NSJSONReadingAllowFragments
                                                                        error:&parseError];
                
            }
            else
            {
                NSLog(@"Error   %ld ", (long)httpResponse.statusCode);
            }
        }];
        
        
        [dataTask resume];
        
        [self updateLabel:_callories];
    }
}

- (void)updateLabel:(NSString *)text {
    self.unswerLabel.text = [NSString stringWithFormat:@"callories = %@", text];
}

@end
