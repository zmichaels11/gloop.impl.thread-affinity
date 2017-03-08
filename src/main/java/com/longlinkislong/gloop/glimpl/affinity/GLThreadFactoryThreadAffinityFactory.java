/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.longlinkislong.gloop.glimpl.affinity;

import com.longlinkislong.gloop.glspi.ThreadFactoryFactory;
import java.util.concurrent.ThreadFactory;
import net.openhft.affinity.AffinityStrategies;
import net.openhft.affinity.AffinityThreadFactory;

/**
 *
 * @author zmichaels
 */
public class GLThreadFactoryThreadAffinityFactory implements ThreadFactoryFactory {

    @Override
    public ThreadFactory getThreadFactory() {
        return new AffinityThreadFactory("GLThread", false, AffinityStrategies.SAME_CORE, AffinityStrategies.ANY);
    }
    
}
