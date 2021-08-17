# Frida hook to bypass YouTube Ads;
# tested on YouTube 16.32.6 (iOS version)
# by bl4ckh0l3z

var target = ObjC.classes.YTAdInterrupt;
Interceptor.attach(target['- initWithAd:adBreak:timingData:'].implementation, {
  onEnter: function (args) {
    console.log('\n\nEntering - initWithAd:adBreak:timingData:!');
  },
  onLeave: function (retval) {
    console.log('  [!] Skip Ads!!!\n');
    console.log('      by bl4ckh0l3z\n\n');
    retval.replace(0);
  },
});
