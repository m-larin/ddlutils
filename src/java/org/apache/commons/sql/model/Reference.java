/*
 * Copyright 1999-2002,2004 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.sql.model;


public class Reference implements Cloneable
{
    private String local;
    private String foreign;
    
    public Reference() {}

    /* (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    public Object clone() throws CloneNotSupportedException
    {
        Reference result = new Reference();

        result.local   = local;
        result.foreign = foreign;
        return result;
    }

    public String getLocal()
    {
        return local;
    }
    
    public void setLocal(String local)
    {
        this.local = local;
    }
    
    public String getForeign()
    {
        return foreign;
    }
    
    public void setForeign(String foreign)
    {
        this.foreign = foreign;
    }
}
