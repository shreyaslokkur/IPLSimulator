package com.siksha.prototype.test;

import org.springframework.core.io.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: shreyasl
 * Date: 10/8/14
 * Time: 4:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class ResourceInjection {


        public Resource _resource;

        public Resource getResource()
        {
            return _resource;
        }

        public void setResource(Resource resource)
        {
            this._resource = resource;
        }


}
