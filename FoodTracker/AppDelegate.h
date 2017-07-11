//
//  AppDelegate.h
//  FoodTracker
//
//  Created by Viktoriia Vovk on 7/11/17.
//  Copyright © 2017 Viktoriia Vovk. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <CoreData/CoreData.h>

@interface AppDelegate : UIResponder <UIApplicationDelegate>

@property (strong, nonatomic) UIWindow *window;

@property (readonly, strong) NSPersistentContainer *persistentContainer;

- (void)saveContext;


@end

