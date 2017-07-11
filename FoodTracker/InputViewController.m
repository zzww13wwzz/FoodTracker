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
    self.unswerLabel.text = @"Please write weight";
}

- (void)textFieldDidBeginEditing:(UITextField *)textField
{
    
}


- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
}

- (IBAction)onPushButtonTap:(id)sender {
    self.unswerLabel.text = @"result = bla bla";
}

@end
