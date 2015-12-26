package com.sysu.workflow.engine;

import java.util.Stack;

/**
 * ҵ�����ʵ����
 * Created by zhengshouzi on 2015/12/26.
 */
public class SCXMLInstanceTree {

    public TreeNode root=null;
    public String rootSessionId =null;

    public SCXMLInstanceTree (String sessionId){
        this.rootSessionId = sessionId;
        root = new TreeNode(sessionId,null,null);
    }

    /**
     * ����ڵ�,
     * @param insertLocation ����Ľڵ��sessionId
     * @param insertSessionId ������ڵ��sessionId
     */


    public void insert(String insertLocation,String insertSessionId){

        if (isContainNode(insertLocation)){
            TreeNode node = getNode(insertLocation);

            TreeNode newNode = new TreeNode(insertSessionId,null,null);

            if (node.getLeftChild()==null){
                node.setLeftChild(newNode);
            }else{
                TreeNode brotherNode = node.getLeftChild().getRightBrother();
                TreeNode last = node.getLeftChild();
                while (brotherNode!=null){
                   last = brotherNode;
                    brotherNode = brotherNode.getRightBrother();
                }
                last.setRightBrother(newNode);
            }
        }
    }

    /**
     * ��rootΪ���������Ƿ����sessionId
     * @param root
     * @param sessionId
     * @return
     */
    public boolean isContainNode(String root,String sessionId){
        return getNode(getRoot(),sessionId)==null?false:true;
    }

    /**
     * �ж������Ƿ����sessionId
     * @param sessionId
     * @return
     */
    public boolean isContainNode(String sessionId){

        return getNode(sessionId)==null?false:true;
    }

    /**
     * ���ݸ��ڵ��sessionidѰ�ҽڵ������е�λ��
     * @param tempRoot
     * @param sessionId
     * @return �ҵ��Ľڵ㣬û��Ϊnull
     */
    public TreeNode getNode(TreeNode tempRoot,String sessionId){

        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        nodeStack.push(tempRoot);
        TreeNode node = null;
        while (!nodeStack.empty()){
            node = nodeStack.pop();
            //�������ڵ�
            if (node.getSessionId() == sessionId){
                return node;
            }
            if (node.getRightBrother()!=null){
                nodeStack.push(node.getRightBrother());
            }
            if (node.getLeftChild()!=null){
                nodeStack.push(node.getLeftChild());
            }

        }
        return null;
    }

    /**
     * ������ȱ���
     * @param tempRoot ���������ĸ��ڵ�
     */
    public void depthFirstSearch(TreeNode tempRoot){

        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        nodeStack.push(tempRoot);
        TreeNode node = null;
        while (!nodeStack.empty()){
            node = nodeStack.pop();
            //�������ڵ�
            System.out.print(node.getSessionId());
            if (node.getRightBrother()!=null){
                nodeStack.push(node.getRightBrother());
            }
            if (node.getLeftChild()!=null){
                nodeStack.push(node.getLeftChild());
            }
        }
    }

    public TreeNode getNode(String sessionId){

        return getNode(getRoot(),sessionId);
    }


    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public String getRootSessionId() {
        return rootSessionId;
    }

    public void setRootSessionId(String rootSessionId) {
        this.rootSessionId = rootSessionId;
    }

    /**
     * ��ʾ���Ͻڵ��˽���ڲ���
     */
    private class TreeNode{

        private String sessionId;
        private TreeNode leftChild;
        private TreeNode rightBrother;


        public TreeNode(String sessionId) {
            this.sessionId = sessionId;
        }

        public TreeNode(String sessionId, TreeNode leftChild, TreeNode rightBrother) {
            this.sessionId = sessionId;
            this.leftChild = leftChild;
            this.rightBrother = rightBrother;
        }

        public TreeNode() {
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public TreeNode getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(TreeNode leftChild) {
            this.leftChild = leftChild;
        }

        public TreeNode getRightBrother() {
            return rightBrother;
        }

        public void setRightBrother(TreeNode rightBrother) {
            this.rightBrother = rightBrother;
        }
    }

}

