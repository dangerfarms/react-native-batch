
#if __has_include("RCTBridgeModule.h")
#import "RCTBridgeModule.h"
#else
#import <React/RCTBridgeModule.h>
#endif

#if __has_include("../../../ios/Pods/Batch/Batch.embeddedframework/Batch.framework/Headers/Batch.h")
#import "../../../ios/Pods/Batch/Batch.embeddedframework/Batch.framework/Headers/Batch.h"
#else
#import "../../../ios/Frameworks/Batch.embeddedframework/Batch.framework/Headers/Batch.h"
#endif

@interface RNBatch : NSObject <RCTBridgeModule>

@end
