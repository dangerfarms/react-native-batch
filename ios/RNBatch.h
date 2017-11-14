
#if __has_include("RCTBridgeModule.h")
#import "RCTBridgeModule.h"
#else
#import <React/RCTBridgeModule.h>
#endif

#import "../../../ios/Frameworks/Batch.embeddedframework/Batch.framework/Headers/Batch.h"

@interface RNBatch : NSObject <RCTBridgeModule>

@end
