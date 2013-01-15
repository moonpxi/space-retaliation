package retaliation;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

public class SampleTest {
    Mockery context = new Mockery();
//    {{
//        setImposteriser(ClassImposteriser.INSTANCE);
//    }};
    
    public interface SomeInterface {
        public void performAction();
    }

    public class Sample {
    
        private SomeInterface someInterface;

        public Sample(SomeInterface someInterface) {
            this.someInterface = someInterface;
        }
        
        public void dummyMethod() {
            someInterface.performAction();
        }
    }

    @Test
    public void testingJMockWorks() {
        final SomeInterface someInterface = context.mock(SomeInterface.class);       
        
        Sample sample = new Sample(someInterface);
        
        context.checking(new Expectations() {{
            oneOf(someInterface).performAction();
        }});
        
        sample.dummyMethod();
        
        context.assertIsSatisfied();
    }

}
