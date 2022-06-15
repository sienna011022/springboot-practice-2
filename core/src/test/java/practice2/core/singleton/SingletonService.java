package practice2.core.singleton;

public class SingletonService {
    //static으로 자기 인스턴스 하나 생성해서 하나 넣어둠

    private static final SingletonService instance = new SingletonService();
    //instance를 꺼낼 방법은 getInstance()호출 밖에 없음
    public static SingletonService getInstance(){
        return instance;
    }
    //다른 곳에서 다시 생성 못하도록 private 걸어 두기
    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }


}
