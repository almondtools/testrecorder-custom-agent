package net.amygdalum.testrecorder.customagent.profile;

import static java.util.Arrays.asList;

import java.util.List;

import net.amygdalum.testrecorder.DefaultSerializationProfile;
import net.amygdalum.testrecorder.profile.Classes;
import net.amygdalum.testrecorder.profile.SerializationProfile;

public class CustomSerializationProfile extends DefaultSerializationProfile implements SerializationProfile {
	@Override
	public List<Classes> getClasses() {
		return asList(Classes.byPackage("net.amygdalum.testrecorder.appexamples"));
	}
}
