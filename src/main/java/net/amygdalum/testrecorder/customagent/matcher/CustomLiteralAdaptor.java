package net.amygdalum.testrecorder.customagent.matcher;

import net.amygdalum.testrecorder.deserializers.Adaptor;
import net.amygdalum.testrecorder.deserializers.Deserializer;
import net.amygdalum.testrecorder.deserializers.matcher.DefaultLiteralAdaptor;
import net.amygdalum.testrecorder.deserializers.matcher.DefaultMatcherGenerator;
import net.amygdalum.testrecorder.deserializers.matcher.MatcherGenerator;
import net.amygdalum.testrecorder.types.Computation;
import net.amygdalum.testrecorder.types.DeserializationException;
import net.amygdalum.testrecorder.values.SerializedLiteral;

public class CustomLiteralAdaptor extends DefaultMatcherGenerator<SerializedLiteral> implements MatcherGenerator<SerializedLiteral> {

	private boolean firstUse = true;

	@Override
	public Class<? extends Adaptor<SerializedLiteral>> parent() {
		return DefaultLiteralAdaptor.class;
	}

	@Override
	public Class<SerializedLiteral> getAdaptedClass() {
		return SerializedLiteral.class;
	}

	@Override
	public Computation tryDeserialize(SerializedLiteral value, Deserializer generator) throws DeserializationException {
		if (firstUse) {
			firstUse = false;
			System.out.println("tried " + CustomLiteralAdaptor.class.getName());
		}
		throw new DeserializationException("should fall back to parent implementation");
	}

}
