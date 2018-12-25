package com.config.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class ZkConnection implements InitializingBean {

    private static final String ZK_IP = "localhost:2181";
    private static final int ZK_CONNECTION_TIME = 15000;

    CuratorFramework curatorFramework;


    @Override
    public void afterPropertiesSet() throws Exception {

        curatorFramework = CuratorFrameworkFactory.newClient(ZK_IP, new ExponentialBackoffRetry(1000, 3));
        curatorFramework.start();
        System.out.println("连接zk");

        NodeCache nodeCache =new NodeCache(curatorFramework,"/test",false);
        nodeCache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.out.println("the test node is change and result is :");
                System.out.println("path : "+nodeCache.getCurrentData().getPath());
                System.out.println("data : "+new String(nodeCache.getCurrentData().getData()));
                System.out.println("stat : "+nodeCache.getCurrentData().getStat());
            }
        });
        nodeCache.start();

    }


}
