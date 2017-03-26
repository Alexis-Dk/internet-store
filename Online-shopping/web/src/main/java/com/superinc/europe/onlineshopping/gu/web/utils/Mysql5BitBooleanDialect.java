package com.superinc.europe.onlineshopping.gu.web.utils;

import org.hibernate.dialect.MySQL5Dialect;

public class Mysql5BitBooleanDialect extends MySQL5Dialect{     
    public Mysql5BitBooleanDialect() {
        super();
        registerColumnType( java.sql.Types.BOOLEAN, "bit" );        
    }       
}
