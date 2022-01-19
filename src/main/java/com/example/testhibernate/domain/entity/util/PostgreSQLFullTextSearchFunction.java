package com.example.testhibernate.domain.entity.util;

import org.hibernate.QueryException;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.engine.spi.Mapping;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.type.BooleanType;
import org.hibernate.type.Type;

import java.util.List;

/**
 * Created by ballmw on 9/14/16.
 */
public class PostgreSQLFullTextSearchFunction implements SQLFunction {
    @Override
    public Type getReturnType(Type columnType, Mapping mapping)
            throws QueryException {
        return new BooleanType();
    }

    @Override
    public boolean hasArguments() {
        return true;
    }

    @Override
    public boolean hasParenthesesIfNoArguments() {
        return false;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public String render(Type firstArgumentType, List args, SessionFactoryImplementor factory) throws QueryException {
        if (args != null && args.size() < 2) {
            throw new IllegalArgumentException(
                    "The function must be passed 2 arguments");
        }

        /*to_tsvector('english', body) @@ to_tsquery('english', 'friend')*/
        String fragment = null;
        String ftsConfig = null;
        String field = null;
        String value = null;

        if (args.size() == 3) {
            ftsConfig = (String) args.get(0);
            field = (String) args.get(1);
            value = (String) args.get(2);
            fragment = " to_tsvector("+ftsConfig+", " + field + ")" + " @@ to_tsquery(" + ftsConfig + ", " + value + ") ";
        } else {
            field = (String) args.get(0);
            value = (String) args.get(1);
            fragment = " to_tsvector('english', " + field + ")" + " @@ to_tsquery('english', " + value + ") ";
        }

        return fragment;
    }


}
