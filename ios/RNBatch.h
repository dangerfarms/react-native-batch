
#if __has_include(<React/RCTAssert.h>)
#import <React/RCTBridgeModule.h>
#import <React/RCTUtils.h>
#else // back compatibility for RN version < 0.40
#import "RCTBridgeModule.h"
#import "RCTUtils.h"
#endif

@interface RNBatch : NSObject <RCTBridgeModule>
@end
