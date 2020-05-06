package com.othr.ajp.mocker;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Invocation {
    private final String self;
    private final Method method;
    private final Object[] args;

    public Invocation(String self, Method method, Object[] args) {
        this.self = self;
        this.method = method;
        this.args = args;
    }

    public String getSelf() {
        return self;
    }

    public Method getMethod() {
        return method;
    }

    public Object[] getArgs() {
        return args;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Invocation{")
                .append("self=").append(self)
                .append(", method=").append(method);
        if (args.length > 0) {
            sb.append(", args={");
            for (Object arg : args) {
                sb.append(arg).append(",");
            }
            sb.delete(sb.length() - 1, sb.length());
            sb.append("}");
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Invocation)) return false;

        Invocation that = (Invocation) o;

        if (getSelf() != null ? !getSelf().equals(that.getSelf()) : that.getSelf() != null) return false;
        if (getMethod() != null ? !getMethod().equals(that.getMethod()) : that.getMethod() != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(getArgs(), that.getArgs());
    }

    @Override
    public int hashCode() {
        int result = getSelf() != null ? getSelf().hashCode() : 0;
        result = 31 * result + (getMethod() != null ? getMethod().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getArgs());
        return result;
    }
}
