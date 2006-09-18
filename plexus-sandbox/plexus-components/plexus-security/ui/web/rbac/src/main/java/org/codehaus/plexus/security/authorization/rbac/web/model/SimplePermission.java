package org.codehaus.plexus.security.authorization.rbac.web.model;

/*
 * Copyright 2001-2006 The Codehaus.
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

/**
 * SimplePermission - this is a placeholder for information passed back 
 * and forth between the Action and the Client.
 * 
 * We intentionally do not hook up the actual object to prevent
 * creative injection of fields and values by the untrusted client.
 *
 * @author <a href="mailto:joakim@erdfelt.com">Joakim Erdfelt</a>
 * @version $Id$
 */
public class SimplePermission
{
    private String name;

    private String operationName;

    private String resourceIdentifier;

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getOperationName()
    {
        return operationName;
    }

    public void setOperationName( String operationName )
    {
        this.operationName = operationName;
    }

    public String getResourceIdentifier()
    {
        return resourceIdentifier;
    }

    public void setResourceIdentifier( String resourceIdentifier )
    {
        this.resourceIdentifier = resourceIdentifier;
    }
}
