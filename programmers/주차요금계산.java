/*
https://school.programmers.co.kr/learn/courses/30/lessons/92341
주차요금 계산
*/
class Solution {
    static int[] record, parkingtime;
    static int resultsize = 0;  //정산할 차량 개수
    
    public int[] solution(int[] fees_param, String[] records_param) {
        //init
        record = new int[100000];   //입장 기록
        parkingtime = new int[100000];  //누적 주차 시간
        
        // 한줄씩 입력
        for(int i = 0; i<records_param.length; i++){
            String string = records_param[i];
            
            int hour = (string.charAt(0) - '0') * 10 + string.charAt(1) - '0';
            int min = (string.charAt(3) - '0') * 10 + string.charAt(4) - '0';
            int num = (string.charAt(6) - '0') * 1000 + (string.charAt(7) - '0') * 100 
                        + (string.charAt(8) - '0') * 10 + string.charAt(9) - '0';
            String inout = string.charAt(11) + "" + string.charAt(12);
            
            if(inout.equals("IN")){
                record[num] = hour * 60 + min + 10000;  //입장시간 기록
                if(parkingtime[num] == 0 && record[num] != 23*60+10059) resultsize++;   //새로운 차량이 들어올때마다 카운트해줌(2359빼고)
            }
            else if(inout.equals("OU")){
                //오늘 입장한적없으면 00:00 ~ 나간시간 기록 but 테케에는 이런거 없음
                if(record[num] < 10000) {
                    parkingtime[num] += hour * 60 + min;
                    resultsize++;
                    continue;   
                }
                int diff = hour * 60 + min + 10000 - record[num];   //머문시간 (분)
                
                parkingtime[num] += diff;   //머문시간 만큼 파킹타임 배열에 기록
                record[num] = 0;    //입장시간 초기화
            }
            // System.out.println(hour + " " + min + " " + num + " " +inout);
        }
        
        int cnt = 0;    //결과값 인덱스
        int[] result = new int[resultsize]; //결과값 리턴할거
        
        for(int i = 0; i<10000; i++){
            //들어온적 없으면 컨티뉴
            if(record[i] == 0 && parkingtime[i] == 0) continue;
            
            //아직 안나갔으면 23 59에 나간거로 계산
            if(record[i] > 0){
                parkingtime[i] += (23*60 + 59 + 10000) - record[i];
                record[i] = 0;
            }
            
            //누적 주차기록시간이 있다면 정산
            if(parkingtime[i]> 0){
                result[cnt] = fees_param[1];    //기본요금 초기화
                
                //기본요금 초과시 초과된 시간 만큼 추가
                if(parkingtime[i] > fees_param[0]){
                    result[cnt] += ((parkingtime[i]-fees_param[0]) / fees_param[2]) * fees_param[3];
                    if(((parkingtime[i]-fees_param[0]) % fees_param[2]) > 0) result[cnt] += fees_param[3];
                }
                cnt++;
            }
            if(cnt >= resultsize) break;
        }
        
        
        return result;
    }
}