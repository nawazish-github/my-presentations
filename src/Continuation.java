public class Continuation {

    public static void main(String[] args) {
        var scope = new ContinuationScope("Demo");
        var cont = new java.lang.Continuation(scope, ()->{
            System.out.println("A");
            java.lang.Continuation.yield(scope);
            System.out.println("B");
            java.lang.Continuation.yield(scope);
            System.out.println("C");
            java.lang.Continuation.yield(scope);
        });

        /*while(!cont.isDone()){
            System.out.println("run...");
            cont.run();
        }*/

        cont.run();
        cont.run();
        cont.run();
    }
}
