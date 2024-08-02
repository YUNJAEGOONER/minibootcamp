# project-1

## 작업 방식 (PM & 컨트리뷰터)

| 작업순서 | PM 측 작업 방식       | 컨트리뷰터 측 작업 방식             |
|------|------------------|---------------------------|
| 1    | 리포 생성<br>README.md 생성<br>main 브랜치에 PR 룰 설정 |                               |
| 2    | 개발자 협력자로 초대        | 초대 수락                        |
| 3    | 이슈 생성<br>번호: 1번<br>라벨: enhancement<br>양수인: 개발자 1  | 1번 이슈 확인<br>or<br>양수인 없는 이슈 직접 양수  |
| 4    |                  | `git clone 깃헙주소 .`<br>or<br>`git pull origin main` |
| 5    |                  | `git fetch --prune`       |
| 6    |                  | `git checkout -b enhancement/1`  |
| 7    |                  | 작업 수행                     |
| 8    |                  | `git add .; git commit -m "작업내용"` |
| 9    |                  | `git pull origin main --rebase` |
| 10   |                  | 작업 계속 수행                |
| 11   |                  | `git add .; git commit -m "작업내용"` |
| 12   |                  | `git pull origin main --rebase` |
| 13   |                  | `git push origin enhancement/1`<br>or<br>`git push origin enhancement/1 -f` |
| 14   |                  | 깃허브 접속, PR 생성 버튼 확인 |
| 15   | PR 생성<br>(enhancement/1 => main)<br>양수인과 리뷰어를 PM으로 지정 | |
| 16   | PR 확인, 리젝 또는 머지 결정 | 리젝 확인                      |
| 17   |                  | `git pull origin main --rebase` |
| 18   |                  | 작업 계속 수행                |
| 19   |                  | `git add .; git commit -m "작업내용"` |
| 20   |                  | `git pull origin main --rebase` |
| 21   |                  | `git push origin enhancement/1`<br>or<br>`git push origin enhancement/1 -f` |
| 22   | PR 승인            |                             |
| 23   | squash merge     |                             |
| 24   | 브랜치 삭제           |                             |
| 25   | 이슈 닫기            | 자동으로 닫힐 수 있음                |
| 26   |                  | `git checkout main`        |
| 27   |                  | `git pull origin main`     |
| 28   |                  | `git branch -D enhancement/1` |
| 29   |                  | `git fetch --prune`        |
| 30   | 4번 내용부터 반복      |                             |

## 작업순서 예시

### 프로젝트 매니저
1. 리포 생성
2. README.md 생성
3. main 브랜치에 PR 룰 설정
4. 개발자 1을 협력자로 초대
5. 이슈 생성 (번호: 1번, 라벨: enhancement, 양수인: 개발자 1)
6. PR 확인 및 리젝 또는 머지 결정
7. squash merge
8. 브랜치 삭제
9. 이슈 닫기

### 개발자 1
1. 초대 수락
2. 이슈 확인 또는 양수인 없는 이슈 직접 양수
3. `git clone 깃헙주소 .` 또는 `git pull origin main`
4. `git checkout -b enhancement/1`
5. 작업 수행
6. `git add .; git commit -m "작업내용"`
7. `git pull origin main --rebase`
8. 작업 계속 수행
9. `git add .; git commit -m "작업내용"`
10. `git pull origin main --rebase`
11. `git push origin enhancement/1` 또는 `git push origin enhancement/1 -f`
12. 깃허브 접속, PR 생성
13. 리젝 확인 시 `git pull origin main --rebase` 후 작업 계속 수행 및 push
14. PR 승인 후 squash merge
15. `git checkout main`
16. `git pull origin main`
17. `git branch -D enhancement/1`
18. `git fetch --prune`
19. 새로운 이슈로 반복



## 코드 포매터

이 프로젝트에서는 [네이버 Java 코드 포매터](https://naver.github.io/hackday-conventions-java/)를 따릅니다. 이를 IntelliJ에 자동으로 적용하도록 설정하는 방법은 다음과 같습니다.

### IntelliJ에 네이버 코드 포매터 설정하기

1. **네이버 코드 포매터 XML 다운로드**
   - [네이버 코드 포매터 XML 파일](https://github.com/naver/hackday-conventions-java/blob/master/rule-config/naver-eclipse-formatter.xml)을 다운로드합니다.

2. **IntelliJ에 XML 파일 가져오기**
   - IntelliJ를 열고, 상단 메뉴에서 `File` > `Settings` (또는 `Preferences` on macOS)를 클릭합니다.
   - `Editor` > `Code Style` > `Java`로 이동합니다.
   - 우측 상단의 `톱니바퀴` 버튼을 클릭하고, `Import Scheme` > `Eclipse XML profile`을 선택합니다.
   - 다운로드한 `naver-eclipse-formatter.xml` 파일을 선택합니다.

3. **코드 스타일 설정 적용**
   - 적용된 코드 스타일을 선택하고, `OK` 버튼을 클릭하여 설정을 저장합니다.

### 프로젝트에 코드 스타일 설정 파일 추가

프로젝트 내에서 모든 기여자들이 동일한 코드 스타일을 사용할 수 있도록 코드 스타일 설정 파일을 프로젝트에 포함시킵니다.

### Reformat Code 및 Optimize Imports 설정

- IntelliJ를 열고, 상단 메뉴에서 File > Settings (또는 Preferences on macOS)를 클릭합니다.
- Tools > Actions on Save로 이동합니다.
- "Reformat code" 및 "Optimize imports" 옵션을 선택합니다.
- OK 버튼을 클릭하여 설정을 저장합니다.

이제 IntelliJ에서 파일을 저장할 때마다 자동으로 코드 포맷팅과 import 최적화가 수행됩니다.