package org.example.project001.Synchronize;
/*
* 스레드 동기화란?  (Thread Synchronization)
* 프로세스는 자원과 데이터, 스레드로 구성되어 있다.
* 프로세스는 스레드가 운영체제로부터 자원을
* 할당 받아 소스 코드를 실행하여 데이터를 처리한다.
* 만약, 싱글 스레드 프로세스라면, 공유 데이터에 단 하나의 스레드만이 접근하므로 문제될 것이 없다
* 하지만 멀티 스레드 프로세스의 경우, 두 개 이상의 스레드가 공유 데이터에 동시에 접근하게 되면
* 예상과 벗어난 결과가 나타난다.
*
* <스레드 동기화를 안하는 경우>
실행과정에서 의도적으로 스레드가 동시 접근 가능
*
* <synchronized 를 통해 스레드를 동기화 한 경우>
자바에서는 synchronized 키워드를 통해 메서드나 코드 블록에 작성하여 스레드를 동기화한다.
* 스레드를 동기화 하기 위해서는 임계 영역(Critical section)과 락(Lock)에 대한 이해가 필요하다.
* 임계영역은 둘 이상의 스레드가 동시에 접근해서는 안되는 코드 영역을 뜻한다.
* 하나의 스레드만이 코드를 실행할 수 있는 영역이다.
* 락은 임계 영역을 포함하고 있는 객체에 접근할 수 있는 권한을 의미한다.
*
* 먼저, synchronized 키워드를 통해 동시 접근이 가능한 영역을 임계영역으로 설정,
* 동시접근을 못하도록 설정 * 스레드가 임계 영역에 접근하게 되면, 해당 스레드는 Lock을 얻게 된다.
* 이후 해당 스레드가 Lock을 반납하기 이전에는 다른 스레드는 해당 임계 영역에 접근 못함.
* sychronized는 메서드 전체를 임계 영역으로 설정하는 방법과
*  특정 코드 블록을 임계 영역으로 설정하는 방법이 있다.
*
* */


public class ThreadSync {
    public static void main(String[] args){
        Runnable thread = new CreateThread();

        // 2개의 작업 스레드 생성
        Thread thread1 = new Thread(thread);
        Thread thread2 = new Thread(thread);

        thread1.setName("스레드1 - 카운터 증가(+)");
        thread2.setName("스레드2 - 카운터 증가(+)");

        thread1. start();
        thread2.start();
    }
}



