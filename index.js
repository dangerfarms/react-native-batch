'use strict';

Object.defineProperty(exports, '__esModule', {
    value: true,
});

var _reactNative = require('react-native');

var Batch = _reactNative.NativeModules.RNBatch;

var eventNameRegex = /^[a-z0-9_]*$/;

Batch.trackEvent = function trackEvent(eventName, label) {
    if (!eventName || eventName.length > 30 || !eventNameRegex.test(eventName)) {
        throw(new Error('Batch event name must be [1-30] char long, can only contain lowercase letters, ' +
            'numbers, and underscore'));
    }
    if (!label) {
        return Batch.trackEventWithName(eventName.toString());
    }
    return Batch.trackEventWithLabel(eventName.toString(), label.toString());
};

exports.default = Batch;
