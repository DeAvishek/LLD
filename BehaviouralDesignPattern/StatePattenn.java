import java.util.*;

interface State{
    void setNextState(StateContext sc);
    void getState();
}
class RedState implements State{
    @Override
    public void setNextState(StateContext sc){
        OragneState or = new OragneState();
        sc.currentState = or;
        System.out.println("State change from red to orange");
    }
    @Override
    public void getState(){
        System.out.println("current state is Red");
    }
}
class OragneState implements State{
    @Override
    public void setNextState(StateContext sc){
        GreeState gn = new GreeState();
        sc.currentState = gn;
        System.out.println("State change from orange to green");
    }
    @Override
    public void getState(){
        System.out.println("current state is Orange");
    }
}
class GreeState implements State{
    @Override
    public void setNextState(StateContext sc){
        RedState rd = new RedState();
        sc.currentState = rd;
        System.out.println("State change from green to red");
    }
    @Override
    public void getState(){
        System.out.println("current state is Green");
    }
}
class StateContext{
    public State currentState;
    public StateContext(RedState rd){
        currentState = rd;
    }
    public void changeState(){
        currentState.setNextState(this);
    }
    public void GetCurrState(){
        currentState.getState();
    }
}
public class StatePattenn {
    public static void main(String args[]){
        RedState rd = new RedState();
        StateContext currState = new StateContext(rd);
        currState.changeState();
        currState.changeState();
        currState.changeState();
        currState.changeState();
        currState.GetCurrState();

    }
}
