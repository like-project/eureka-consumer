package com.like.cloud.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * @ClassName RoundRule
 * @Description TODO
 * @Author Ke
 * @Date 2019/10/18 16:15
 * @Version 1.0
 */
public class RoundRuless extends AbstractLoadBalancerRule {

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    private int total = 0;
    private int currentIndex = 0;

    @Override
    public Server choose(Object o) {
        return chooseServer(getLoadBalancer(),o);

    }


    private Server chooseServer(ILoadBalancer loadBalancer, Object o) {
        if (loadBalancer == null){
            return null;
        }
        Server server = null;
        while (server == null){
            if (Thread.interrupted()){
                return null;
            }
            List<Server> reachableServers = loadBalancer.getReachableServers();
            List<Server> allServers = loadBalancer.getAllServers();

            if (allServers.size() == 0){
                return null;
            }

            if (total < 5){
                server = reachableServers.get(currentIndex);
                total++;
            } else {
                total = 0;
                currentIndex++;
                if (currentIndex >= allServers.size()){
                    currentIndex = 0;
                }
            }

            if (server == null){
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }
            server = null;
            Thread.yield();
        }


        return server;
    }



}
