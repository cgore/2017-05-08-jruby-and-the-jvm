

import org.jruby.Ruby;
import org.jruby.RubyObject;
import org.jruby.runtime.Helpers;
import org.jruby.runtime.builtin.IRubyObject;
import org.jruby.javasupport.JavaUtil;
import org.jruby.RubyClass;


public class Foo extends RubyObject  {
    private static final Ruby __ruby__ = Ruby.getGlobalRuntime();
    private static final RubyClass __metaclass__;

    static {
        String source = new StringBuilder(" class Foo\n" +
            "   def bar(a, b)\n" +
            "     puts a + b\n" +
            "   end\n" +
            " end\n" +
            "").toString();
        __ruby__.executeScript(source, "ruby_foo.rb");
        RubyClass metaclass = __ruby__.getClass("Foo");
        if (metaclass == null) throw new NoClassDefFoundError("Could not load Ruby class: Foo");
        metaclass.setRubyStaticAllocator(Foo.class);
        __metaclass__ = metaclass;
    }

    /**
     * Standard Ruby object constructor, for construction-from-Ruby purposes.
     * Generally not for user consumption.
     *
     * @param ruby The JRuby instance this object will belong to
     * @param metaclass The RubyClass representing the Ruby class of this object
     */
    private Foo(Ruby ruby, RubyClass metaclass) {
        super(ruby, metaclass);
    }

    /**
     * A static method used by JRuby for allocating instances of this object
     * from Ruby. Generally not for user comsumption.
     *
     * @param ruby The JRuby instance this object will belong to
     * @param metaclass The RubyClass representing the Ruby class of this object
     */
    public static IRubyObject __allocate__(Ruby ruby, RubyClass metaClass) {
        return new Foo(ruby, metaClass);
    }

    /**
     * Default constructor. Invokes this(Ruby, RubyClass) with the classloader-static
     * Ruby and RubyClass instances assocated with this class, and then invokes the
     * no-argument 'initialize' method in Ruby.
     */
    public Foo() {
        this(__ruby__, __metaclass__);
        Helpers.invoke(__ruby__.getCurrentContext(), this, "initialize");
    }


    
    public Object bar(Object a, Object b) {
        IRubyObject ruby_arg_a = JavaUtil.convertJavaToRuby(__ruby__, a);
        IRubyObject ruby_arg_b = JavaUtil.convertJavaToRuby(__ruby__, b);
        IRubyObject ruby_result = Helpers.invoke(__ruby__.getCurrentContext(), this, "bar", ruby_arg_a, ruby_arg_b);
        return (Object)ruby_result.toJava(Object.class);

    }

}
