package net.amygdalum.testrecorder.customagent.serializer;

import static java.util.Arrays.asList;

import java.util.List;
import java.util.SortedMap;

import net.amygdalum.testrecorder.serializers.DefaultMapSerializer;
import net.amygdalum.testrecorder.types.SerializerSession;
import net.amygdalum.testrecorder.values.SerializedMap;

public class CustomMapSerializer extends DefaultMapSerializer {

	private boolean firstUse = true;

	public CustomMapSerializer() {
	}

	@Override
	public List<Class<?>> getMatchingClasses() {
		return asList(SortedMap.class);
	}

	@Override
	public SerializedMap generate(Class<?> type, SerializerSession session) {
		if (firstUse) {
			firstUse = false;
			System.out.println("using " + CustomMapSerializer.class.getName());
		}
		return super.generate(type, session);
	}
}
