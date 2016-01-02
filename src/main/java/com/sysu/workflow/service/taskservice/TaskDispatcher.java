package com.sysu.workflow.service.taskservice;

import com.sysu.workflow.service.indentityservice.IdentityService;
import com.sysu.workflow.service.indentityservice.User;

/**
 * ���������
 * Created by zhengshouzi on 2015/12/24.
 */
public class TaskDispatcher {

    public static TaskDispatcher taskDispatcher;

    public static TaskDispatcher newInstance() {
        return taskDispatcher == null ? new TaskDispatcher() : taskDispatcher;
    }


    public void dispatchUserTask(Task task) {

        TaskService taskService = new TaskService();
        IdentityService identityService = new IdentityService();

        boolean flag = false;
        try {

            //�ҵ������
            User user = identityService.createUserQuery().userRealName(task.getAssignee()).SingleResult();

            flag = user.addIntoWorkItem(task);

            //���flag����true����ʾ���빤�����ʧ�ܣ��׳� error.execute�쳣

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
