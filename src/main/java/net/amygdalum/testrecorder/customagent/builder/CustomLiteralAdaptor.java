package net.amygdalum.testrecorder.customagent.builder;

import net.amygdalum.testrecorder.deserializers.Adaptor;
import net.amygdalum.testrecorder.deserializers.Deserializer;
import net.amygdalum.testrecorder.deserializers.builder.DefaultLiteralAdaptor;
import net.amygdalum.testrecorder.deserializers.builder.DefaultSetupGenerator;
import net.amygdalum.testrecorder.deserializers.builder.SetupGenerator;
import net.amygdalum.testrecorder.types.Computation;
import net.amygdalum.testrecorder.types.DeserializationException;
import net.amygdalum.testrecorder.values.SerializedLiteral;

public class CustomLiteralAdaptor extends DefaultSetupGenerator<SerializedLiteral> implements SetupGenerator<SerializedLiteral> {

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
			System.out.println("using " + CustomLiteralAdaptor.class.getName());
		}
		throw new DeserializationException("should fall back to parent implementation");
	}

}
