package org.example.project001.Synchronize;


class CreateThread implements Runnable{
    Count MyCount = new Count();
    private int count = 0;

    public void run(){
        while (MyCount.getCount() < 2000){
            count++;

            // 증가 실행 코드. 실패시 true 반환
            //이 메서드는 카운트를 증가 성공하면 true를 반환하고 실패하면 false를 반환
            boolean denied =!MyCount.increment(count);

            // 증가 과정 출력
            if (denied) {
                System.out.println("증가 거부");
                System.out.printf("스레드 : %s 증가 : %d final count : %d\n\n",
                        Thread.currentThread().getName(), count, MyCount.getCount());
            }else {
                System.out.printf("스레드 : %s 증가 : %d final count : %d\n\n",
                        Thread.currentThread().getName(), count, MyCount.getCount());

                /* System.out.println 메서드가 가변 인수를 받지 않기 때문입니다.
                 이 경우 System.out.printf를 사용하여 서식을 지정한 문자열과
                 값을 함께 출력할 수 있습니다.*/



            }
        }
    }
}