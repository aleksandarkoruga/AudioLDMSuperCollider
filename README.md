# AudioLDMSupercollider
 A SuperCollider class which calls the AudioLDM command line tool for generating text-to-audio

# Requirements 
 - AudioLDM command line tool https://github.com/haoheliu/AudioLDM
  - tl;dr `pip3 install audioldm`

 - Copy AudioLDM.sc to your 'Extensions' folder

# Usage

```
s.boot;
({
~buf=AudioLDM.generateFromText(s,"C:/Users/Public/Music",  "funky slap bass at 170 bpm in e minor key, decorated with triplets and mute notes", 10000.rand, 1);
{  PlayBuf.ar(1, ~buf[0], BufRateScale.kr(~buf[0]), 1.0, 0.0, 1.0)  }.play;
}.fork
)
~buf.do(_.free);
```
# AudioLDM.generateFromText
 - Arguments are: server, output path (can be a non-existing folder, will be created upon call if permissions allow it), description, seed, duration (x2.5 internally, so 1 = 2.5, 2 = 5.0 etc)
 - Returns an array of buffers. The array will contain all the samples found in the specified output folder which contain the description provided. So in case of multiple runs with the same/nested descritption all files are loaded. 
