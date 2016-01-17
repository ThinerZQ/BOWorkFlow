package com.sysu.workflow.service.taskservice;

import com.sysu.workflow.service.indentityservice.IdentityService;
import com.sysu.workflow.service.indentityservice.UserEntity;
import com.sysu.workflow.service.indentityservice.WorkItemEntity;

import java.util.ArrayList;

/**
 * ���������
 * Created by zhengshouzi on 2015/12/24.
 */
public class TaskDispatcher {

    public static TaskDispatcher taskDispatcher;

    public static TaskDispatcher newInstance() {
        return taskDispatcher == null ? new TaskDispatcher() : taskDispatcher;
    }



    public void dispatchUserTask(ArrayList<WorkItemEntity> workItemEntityArrayList) {


    }
    public void dispatchUserTask(WorkItemEntity workItemEntity,String assignee) {

        IdentityService identityService = new IdentityService();
        WorkItemDao workItemDao = new WorkItemDao();

        boolean flag = false;
        try {

            //�ҵ������
            UserEntity user = identityService.createUserQuery().userRealName(assignee).SingleResult();

            if (user!=null){
                workItemEntity.setItemAssigneeName(user.getUserName()).setItemAssigineeId(String.valueOf(user.getUserId()));
                flag = workItemDao.insertIntoWorkItem(workItemEntity);
            }else{
                //�׳��쳣
            }

            //���flag����true����ʾ���빤�����ʧ�ܣ��׳� error.execute�쳣

            //TODO:�׳��쳣
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
