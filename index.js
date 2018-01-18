'use strict';

Object.defineProperty(exports, '__esModule', {
    value: true,
});

var _reactNative = require('react-native');

var Batch = _reactNative.NativeModules.RNBatch;

var eventNameRegex = /^[a-z0-9_]*$/;

Batch.trackEvent = function trackEvent(eventName, label, data) {
    if (!eventName || eventName.length > 30 || !eventNameRegex.test(eventName)) {
        throw(new Error('Batch event name must be [1-30] char long, can only contain lowercase letters, ' +
            'numbers, and underscore'));
    }
    var eventOnly = eventName && !label && !data;
    var eventWithLabel = eventName && label && !data;
    var eventWithLabelAndData = eventName && label && data;
    if (eventOnly) {
        return Batch.trackEventWithName(eventName.toString());
    } else if (eventWithLabel) {
        return Batch.trackEventWithLabel(eventName.toString(), label.toString());
    }
    return Batch.trackEventWithLabelAndData(eventName.toString(), label.toString(), data);
};

exports.default = Batch;
