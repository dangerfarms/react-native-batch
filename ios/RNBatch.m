
#import "RNBatch.h"

@implementation RNBatch

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE()

- (id)init {
    self = [super init];

    if (self != nil) {
        NSDictionary *info = [[NSBundle mainBundle] infoDictionary];
        NSString *batchAPIKey = [info objectForKey:@"BatchAPIKey"];

        [Batch startWithAPIKey:batchAPIKey];
    }

    return self;
}

+ (BOOL)requiresMainQueueSetup
{
    return YES;
}

RCT_EXPORT_METHOD(registerForRemoteNotifications)
{
    [BatchPush registerForRemoteNotifications];
}

RCT_EXPORT_METHOD(login:(nullable NSString*)userID)
{
    BatchUserDataEditor *editor = [BatchUser editor];
    [editor setIdentifier:userID];
    [editor save];
}

RCT_EXPORT_METHOD(logout)
{
    BatchUserDataEditor *editor = [BatchUser editor];
    [editor setIdentifier:nil];
    [editor save];
}

RCT_EXPORT_METHOD(trackLocation:(NSDictionary*)position)
{
    double latitude = [position[@"latitude"] doubleValue];
    double longitude = [position[@"longitude"] doubleValue];
    double accuracy = [position[@"accuracy"] doubleValue];
    NSDate* now = [NSDate date];

    CLLocation *location = [[CLLocation alloc] initWithCoordinate:CLLocationCoordinate2DMake(latitude, longitude)
                                                         altitude:0
                                               horizontalAccuracy:accuracy
                                                 verticalAccuracy:-1
                                                        timestamp:now];

    [BatchUser trackLocation:location];
}

RCT_EXPORT_METHOD(trackEventWithLabel:(NSString*) eventName label:(NSString*) label)
{
    [BatchUser trackEvent:eventName withLabel:label];
}

RCT_EXPORT_METHOD(trackEventWithLabelAndData:(NSString*) eventName label:(NSString*) label data:(NSDictionary*) data)
{
    [BatchUser trackEvent:eventName withLabel:label data:data];
}

RCT_EXPORT_METHOD(trackEventWithName:(NSString*) eventName)
{
    [BatchUser trackEvent:eventName];
}

RCT_EXPORT_METHOD(setMobileLandingFontOverride:(NSString*) normal bold:(NSString*) bold)
{
    NSString *normalFontName = [[normal lastPathComponent] stringByDeletingPathExtension];
    NSString *boldFontName = [[bold  lastPathComponent] stringByDeletingPathExtension];

    // Note: size is overriden
    UIFont* normalFont = [UIFont fontWithName:normalFontName size: 10];
    UIFont* boldFont = [UIFont fontWithName:boldFontName size: 10];

    [BatchMessaging setFontOverride:normalFont boldFont:boldFont];
}

RCT_EXPORT_METHOD(resetMobileLandingFont)
{
    [BatchMessaging setFontOverride:nil boldFont:nil];
}

RCT_REMAP_METHOD(getInstallationId,
                 resolver:(RCTPromiseResolveBlock)resolve
                 rejecter:(RCTPromiseRejectBlock)reject)
{
    resolve([BatchUser installationID]);
}

@end
