package com.sysu.workflow.model;

import com.sysu.workflow.ActionExecutionContext;
import com.sysu.workflow.Context;
import com.sysu.workflow.Evaluator;
import com.sysu.workflow.SCXMLExpressionException;
import com.sysu.workflow.identityservice.IdentityService;
import com.sysu.workflow.identityservice.User;
import com.sysu.workflow.taskservice.Task;
import com.sysu.workflow.taskservice.TaskService;

import java.util.Date;

/**
 * Created by zhengshouzi on 2015/12/11.
 */
public class UserTask extends Action {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String assignee;
    private String candidateUsers;
    private String candidateGroups;
    private String dueDate;
    private int instances=1;

    public UserTask() {
        super();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getCandidateUsers() {
        return candidateUsers;
    }

    public void setCandidateUsers(String candidateUsers) {
        this.candidateUsers = candidateUsers;
    }

    public String getCandidateGroups() {
        return candidateGroups;
    }

    public void setCandidateGroups(String candidateGroups) {
        this.candidateGroups = candidateGroups;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getInstances() {
        return instances;
    }

    public void setInstances(int instances) {
        this.instances = instances;
    }

    @Override
    public void execute(ActionExecutionContext exctx) throws ModelException, SCXMLExpressionException {

        EnterableState parentState = getParentEnterableState();
        Context ctx = exctx.getContext(parentState);
        ctx.setLocal(getNamespacesKey(), getNamespaces());
        Evaluator eval = exctx.getEvaluator();


        //������Ա��ʽ��ֵ���ʽ��ֵ


        // ������˵Ĺ����б��������
        TaskService taskService = new TaskService();
        IdentityService identityService = new IdentityService();
        Task task = taskService.newTask(getName());
        task.setDueDate(getDueDate())
                .setProcessId((String)ctx.getSystemContext().getPlatformVariables().get("_sessionid"))
                .setCreateDate(new Date().toString());

        boolean flag= false;

        if (getInstances()==1){
            //�ҵ������
            User user = identityService.createUserQuery().userRealName(getAssignee()).SingleResult();
            flag = taskService.insertInToWorkItem(user,task);
        }else {

        }






        //���flag����true����ʾ���빤�����ʧ�ܣ��׳� error.execute�쳣


    }
}
