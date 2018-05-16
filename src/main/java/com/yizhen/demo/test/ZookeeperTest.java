package com.yizhen.demo.test;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZookeeperTest {

	private static final int TIME_OUT = 3000;
    private static final String HOST = "localhost:2181";
	public static void main(String[] args) throws Exception{
		Logger logger = LoggerFactory.getLogger(ZooKeeper.class);
		Watcher customWatcher = new CustomWatcher();
		ZooKeeper zookeeper = new ZooKeeper(HOST, TIME_OUT, customWatcher);
		zookeeper.register(customWatcher);
		logger.info("=========创建节点===========");
		logger.info("zookeeper state = "+zookeeper.getState());
        if(zookeeper.exists("/test", false) == null)
        {
            //创建一个节点，里面的数据是znode1
        	zookeeper.create("/test", "znode1".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        logger.info("=============查看节点是否安装成功===============");
        logger.info(new String(zookeeper.getData("/test", true, null)));
        logger.info("=========修改节点的数据==========");
        String data = "zNode2";
		zookeeper.setData("/test", data.getBytes(), -1);
		logger.info("========查看修改的节点是否成功=========");
		logger.info(new String(zookeeper.getData("/test", true, null)));
		logger.info("=======删除节点==========");
        zookeeper.delete("/test", -1);
        logger.info("==========查看节点是否被删除============");
        logger.info("节点状态：" + zookeeper.exists("/test", customWatcher));
        zookeeper.close();
	}
}

/**
 * 事件处理器类
 * @author liuyizhen
 */
class CustomWatcher implements Watcher{
	Logger logger = LoggerFactory.getLogger(CustomWatcher.class);
	@Override
	public void process(WatchedEvent event) {
		if(event.getType() == EventType.NodeDeleted) {
			logger.info("节点删除");
		}
		else if(event.getType() == EventType.NodeDataChanged) {
			logger.info("节点数据变更");
		}else {
			//什么也不做
		}
	}
	
}
