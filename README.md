# 2023-2-algorithm
2023-2 학기 네스트넷 알고리즘 스터디 

<h2>
  :man_technologist: 스터디 진행 방식 
</h2>
<h3><b>1. 문제 선정 </b> </h3>
<details>
  <summary>자세히</summary>
  <ul>
    <li>매 주 금~일에 <a href="https://devjeong.com/algorithm/algorithm-1/">백준 문제 추천 사이트</a>에서 알고리즘 당 세 문제를 선정한다. (스터디장 주관)</li>
    <li>문제 선정 후 <a href="https://www.acmicpc.net/group/workbook/18220">백준 23-2 네넷 알고리즘 스터디 그룹</a>에 주차+문제를 추가한다. (스터디장 or 도현 주관)</li>
    <li>이슈를 작성한다. (스터디장 주관)</li>
  </ul>
</details>

<br>

<h3><b>2. 문제 풀이 </b> </h3>
<details>
  <summary>자세히</summary>
  <ul>
    <li>폴더 구조 : 본인 이름 / week_해당 주 / Boj문제번호 이름으로 설정한 소스코드 <b>ex) KimSeongHo / week_1 / Boj1343.java</b> </li>
    <li>30분 ~ 1시간 생각해도 방법이 떠오르지 않으면 구글에 검색 후 공부하여 문제를 푼다. </li>
    <li>복잡한 부분이나 핵심 알고리즘에 주석을 단다.</li>
  </ul>
</details>

<br>

<h3><b>3. 깃 관리 + Issue & PR(Pull Request) </b> </h3>
<details>
  <summary>자세히</summary>
  <ol>
    <li>프로젝트를 생성한다.</li>
    <li>
      Nestnet-study Organization의 nestnet_algorithm_2023_2 레포지토리를 fork 한다
      <img src="https://github.com/Nestnet-study/nestnet_algorithm_2023_2/assets/81570533/d508321f-85e7-4e87-a9af-eba45c1a9f37", width=100%>
    </li>
    <li>
      fork 후에는 내 레포지토리가 생기는데, organization의 레포지토리는 "organization 이름 / 레포지토리 이름" 인데, 내 레포지토리는 "아이디 / 레포지토리 이름" 인 것을 확인할 수 있다. 해당 레포지토리를 clone한다. 
      <img src="https://github.com/Nestnet-study/nestnet_algorithm_2023_2/assets/81570533/1eb7b8b0-c360-46a4-b922-2098b6200048", width=100%>
    </li>
    <li>
      프로젝트를 생성하고 적절한 위치에서 "git clone 레포지토리" 를 해준다. 내 경우, C:\InteliJ_workspace\2023-nestnet-algo\src\ 하위에서 clone을 해주었다.(java) <br>
      클론한 레포지토리 하위에 본인의 이름으로 폴더를 생성하고, 해당 폴더 하위에 주차별 패키지를 만든다. 템플릿 : <b>이름/week_해당주차</b> <br> ex) KimSeongHo/week_1
      <img src="https://github.com/Nestnet-study/nestnet_algorithm_2023_2/assets/81570533/6cbaef03-6027-4ff7-b2a7-8004047ddf34", width=100%>
      <img src="https://github.com/Nestnet-study/nestnet_algorithm_2023_2/assets/81570533/16f934d6-8fbc-4ac0-97df-026e3d8d429b", width=100%>
    </li>
    <li>
      week_해당주차 하위에 소스파일을 생성한다. 템플릿 : <b>Boj문제번호</b> ex) week_1/Boj1343.java
    </li>
    <li>
      해당 주차 문제를 모두 풀면 "git add 본인 이름" -> git commit -m "(#이슈번호) [해당주차] 이름" 으로 커밋을 한 후 본인 레포지토리에 push 한다. ex) git commit -m "(#3) [1주차] 김성호"
    </li>
    <li>
      본인 레포지토리에 push가 잘 된 것을 확인한 후, 
      <img src="https://github.com/Nestnet-study/nestnet_algorithm_2023_2/assets/81570533/b2929c50-9cb1-454d-aa8c-2cfeaa53abdb", width=100%>
      PR을 생성한다. 
      <img src="https://github.com/Nestnet-study/nestnet_algorithm_2023_2/assets/81570533/dfe7690a-c94d-40c3-b917-bd7ba30792f5", width=100%>
    </li>
    <li>
      head repository는 fork해서 가져온 내 레포지토리이고, base repository는 organization의 레포지토리이다. head의 main 브랜치에서 에서 base의 main 브랜치로 PR을 보내는 것이다.  
      <img src="https://github.com/Nestnet-study/nestnet_algorithm_2023_2/assets/81570533/e6b83f31-89ec-4c28-9e81-0136306a00d2", width=100%>
    </li>
    <li>
      PR 제목 템플릿 : [해당 주차] 이름 ex) [1주차] 김성호 으로 PR을 작성한다. 내용은 각 문제를 쓰고 어떻게 풀었는지, 다른사람에게 알려주고 싶은 내용은 무엇인지 작성한다. (딱히 없으면 뭐..)
      <img src="https://github.com/Nestnet-study/nestnet_algorithm_2023_2/assets/81570533/d30d987a-bdd1-4204-9e05-49ed9652e049", width=100%>
    </li>
  </ol>
</details>

<br>

<b>+ 다른 사람 레포지토리 fork & Pull Request를 통한 협업에 대해 잘 모르겠다면? <a href="https://inpa.tistory.com/entry/GIT-%E2%9A%A1%EF%B8%8F-%EA%B9%83%ED%97%99-PRPull-Request-%EB%B3%B4%EB%82%B4%EB%8A%94-%EB%B0%A9%EB%B2%95-folk-issue">Click!!!</a></b>
