package com.yizhen.demo.designPattern.note;

public class  ClientTest {

	public static void main(String[] args) {
        //发起人
		GameRole liaowp = new GameRole();
	    liaowp.init();
	    liaowp.show();
	    //管理者
	    RoleStateMange adminMange = new RoleStateMange();
	    adminMange.setMemento(liaowp.saveMemento());//保存
        liaowp.fightBoss();
        liaowp.show();
        liaowp.recove(adminMange.getMemento());
        liaowp.show();
	}
}
