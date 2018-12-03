package net.amygdalum.testrecorder.customagent.profile;

import java.nio.file.Paths;

import net.amygdalum.testrecorder.generator.ScheduledTestGenerator;
import net.amygdalum.testrecorder.profile.AgentConfiguration;
import net.amygdalum.testrecorder.profile.SnapshotConsumer;
import net.amygdalum.testrecorder.types.ContextSnapshot;

public class CustomSnapshotConsumer extends ScheduledTestGenerator implements SnapshotConsumer {

	private int no;

	public CustomSnapshotConsumer(AgentConfiguration config) {
		super(config);
		this.counterInterval = 2;
		this.classNameTemplate = "${class}${counter}Test";
		this.counterMaximum = 1000;
		this.generateTo = Paths.get("target/generated");
		this.dumpOnShutdown(true);
		this.no = 0;
	}
	
	@Override
	public void accept(ContextSnapshot snapshot) {
		no++;
		System.out.println("reaching snapshot " + no);
		super.accept(snapshot);
	}

}
