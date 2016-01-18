package com.sysu.workflow.service.taskservice;

import com.sysu.workflow.model.UserException;
import com.sysu.workflow.service.indentityservice.GroupEntity;
import com.sysu.workflow.service.indentityservice.UserEntity;

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
    public void dispatchUserTask(WorkItemEntity workItemEntity,UserEntity userEntity) throws UserException {

        WorkItemDao workItemDao = new WorkItemDao();

        boolean flag = false;
        try {

            if (userEntity!=null){
                workItemEntity.setItemAssigneeEntity(userEntity);
                flag = workItemDao.insertIntoWorkItem(workItemEntity);
            }else{
                //�׳��쳣
                throw new UserException("û���û���"+userEntity.getUserRealName());
            }

            //���flag����true����ʾ���빤�����ʧ�ܣ��׳� error.execute�쳣

            //TODO:�׳��쳣
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void dispatchGroupTask(WorkItemEntity workItemEntity,GroupEntity groupEntity) {

        WorkItemDao workItemDao = new WorkItemDao();

        boolean flag = false;
        try {

            if (groupEntity!=null){
                workItemEntity.setItemCandidateCroupEntity(groupEntity);
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
