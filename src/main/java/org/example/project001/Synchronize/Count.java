package org.example.project001.Synchronize;

class Count {

    private int MyCount = 1990;

    public int getCount() {
        // increment() 메서드는 카운트를 증가
        // getCount() 는 현재 카운트를 반환
        return MyCount;
    }
    public synchronized boolean increment(int count){
        // 가지고 있는 숫자가 증가되다가 한계점에 도달하면 멈춘다.

        if (MyCount < 2000) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // 증가
            MyCount += 1;

            return true;
        } else {
            return false;
        }
    }

}