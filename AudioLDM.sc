AudioLDM
{
	*generateFromText
	{
		|server, path, prompt, seed, duration=1|
		var folderPath = PathName.new(path: path);
		var generatePath = PathName.new(path: (path++"/generation").standardizePath);
		var buffer=[];
		"starting AudioDLM".postln;
		("audioldm -s "++folderPath.fullPath++" -dur "++((duration.asInteger.clip(1,inf)*2.5))++" -t \""++prompt++"\" --seed "++seed).unixCmdGetStdOut();

			generatePath.filesDo{|afile| if(afile.fullPath.contains(prompt),{ buffer=buffer.add(Buffer.readChannel(server,afile.fullPath,channels:[0])) } ); };
		^buffer;

	}
}
