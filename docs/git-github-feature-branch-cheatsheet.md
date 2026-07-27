# Git / GitHub 가이드 (한 사이클)

기준: [Feature Branch Workflow](https://www.atlassian.com/git/tutorials/comparing-workflows/feature-branch-workflow)  
예제: CAB302 Shapes OOP · 상세 → [각주](#각주-상세) · `.html` / `.pdf` 동일 내용

**읽는 법:** 아래 **1 → 9** 가 한 사이클입니다.  
표에서 **「최초」** = 처음·새 PC·새 계정·새 저장소일 때만 (이미 끝났으면 건너뛰기).  
표시 없으면 = 기능을 추가할 때마다.

```
[최초] 계정·Git·저장소 → config → clone
   ↓
① main 맞춤 → ② feature → ③ add/commit → ④ push
   → ⑤ PR → ⑥ 피드백 → ⑦ merge → ⑧ 정리 → (다음 기능은 ①부터)
```

---

## 1. 시작 준비 — 계정 · Git · 저장소

이 단계의 대부분은 **최초**입니다. 저장소 URL이 이미 있고 PC에 clone까지 끝났으면 **2번**으로.

### 1-a. GitHub 계정 〔최초〕

| 어디서 | 할 일 |
|--------|------|
| [github.com](https://github.com) → **Sign up** | 가입 · 이메일 인증 |
| 프로필 → **Settings → Emails** | 커밋에 쓸 이메일 확인/추가 <a id="fnref1"></a>[[1]](#fn1) |
| (선택) **Settings → Profile** | 이름·사진 |

### 1-b. Git 설치 〔최초〕

| Syntax | 의미 | 사용 예 |
|--------|------|---------|
| [git-scm.com](https://git-scm.com) 설치 | 전 플랫폼 Git CLI | 기본 옵션 OK |
| `git --version` | 설치 확인 | `git version 2.x.x` |

**GitHub:** 없음 · **IntelliJ:** Settings → Version Control → Git  

| 옵션 | 의미 |
|------|------|
| [GitHub Desktop (Windows)](https://desktop.github.com) / Mac | GUI로 clone·commit·push (CLI 대신 가능) |

### 1-c. 저장소 확보 〔최초 · clone보다 앞〕 <a id="fnref2"></a>[[2]](#fn2)

**경우 ① 수업/팀 저장소가 이미 있음 (CAB302에 흔함)**

| # | GitHub | 의미 |
|---|--------|------|
| 1 | 원본 저장소 페이지 | 수업 org 등 |
| 2 | **Fork** | 내 계정에 복사본 |
| 3 | 또는 팀장: **Settings → Collaborators** 초대 | 초대 수락 |

**경우 ② 새로 만든다**

| # | GitHub | 의미 |
|---|--------|------|
| 1 | **+ → New repository** | 빈 저장소 |
| 2 | 이름 · Public/Private | |
| 3 | “Add a README” 권장 <a id="fnref3"></a>[[3]](#fn3) | 첫 커밋 |
| 4 | **Create repository** | |
| 5 | **Settings → Collaborators** | 팀원 초대 |

### 1-d. 로컬 신원 설정 〔최초 · PC/계정당〕

| Syntax | 의미 | 사용 예 |
|--------|------|---------|
| `git config --global user.name "이름"` | 커밋 작성자 <a id="fnref1b"></a>[[1]](#fn1) | `..."Alice Kim"` |
| `git config --global user.email "메일"` | GitHub Emails와 동일 | `..."alice@qut.edu.au"` |
| `git config --global -l` | 확인 (보조) | |

| 옵션 / 보조 | 의미 | 사용 예 |
|-------------|------|---------|
| `git config --global color.ui auto` | 터미널 Git 출력 색 자동 | 가독성 (치트시트 SETUP) |
| `git config --global core.excludesfile <파일>` | PC 전체 공통 ignore 목록 | 모든 저장소에 적용할 패턴 <a id="fnref19b"></a>[[19]](#fn19) |

### 1-e. 로컬에 저장소 두기 〔최초〕 — 보통 `clone` / 옵션 `init`

**권장 (원격이 이미 있을 때): `git clone`**

| Syntax | 의미 | 사용 예 |
|--------|------|---------|
| 저장소 → **Code** → URL 복사 | HTTPS 주소 | |
| `git clone <URL>` | 원격 → 로컬 <a id="fnref4"></a>[[4]](#fn4) | `git clone https://github.com/나/repo.git` |
| `cd <폴더>` | 프로젝트로 이동 | `cd shapes` |

이미 clone한 폴더가 있으면 **재clone 하지 말고** 그 폴더에서 2번으로.  
첫 clone/push 시 로그인·토큰 요청 가능 <a id="fnref5"></a>[[5]](#fn5).

**옵션 (로컬에서 먼저 시작할 때): `git init`** — Canvas/수업에서 흔함. `clone`과 **둘 다 하지 않음**.

| Syntax | 의미 | 사용 예 |
|--------|------|---------|
| `cd <부모폴더>` | 둘 위치 | `cd C:/Users/나/Documents` |
| `mkdir <프로젝트>` · `cd <프로젝트>` | 폴더 만들기 | `mkdir example-repo` → `cd example-repo` |
| (선택) `mkdir src` | IntelliJ식 소스 폴더 | |
| `git init` | 여기에 빈 Git 저장소 생성 (`.git`) [[4]](#fn4) | 탐색기에 숨김 `.git` 생김 |
| (이어서) 파일 작성 → `add` → `commit` | 첫 로컬 커밋 | 4번과 동일 |
| GitHub에 빈 저장소 생성 (README 없이) | 1-c 경우 ② | |
| `git remote add origin <URL>` | 원격 연결 | `git remote add origin https://...` |
| `git push -u origin main` | 첫 업로드 | 브랜치명이 `master`면 그에 맞춤 |

| 보조 | 의미 | 언제 |
|------|------|------|
| `git remote -v` | `origin` 확인 | clone/init 직후 |
| `git remote add upstream <원본URL>` | Fork 시 원본 연결 <a id="fnref6"></a>[[6]](#fn6) | 〔최초·Fork〕 |
| **Settings → SSH and GPG keys** + `ssh-keygen` | SSH 인증 <a id="fnref7"></a>[[7]](#fn7) | 〔최초·선택〕 |

### 1-f. main 보호 〔최초 · 팀장 권장〕

| GitHub | 의미 |
|--------|------|
| **Settings → Branches / Rules** → `main` 보호 | 직접 push 금지, PR 리뷰 필수 <a id="fnref8"></a>[[8]](#fn8) |

### 1-g. `.gitignore` 〔최초 · 프로젝트당 · 옵션〕

커밋하면 안 되는 파일 패턴을 저장소 루트 `.gitignore`에 적습니다 <a id="fnref19"></a>[[19]](#fn19).

| 예 패턴 | 의미 |
|---------|------|
| `logs/` · `*.class` · `.idea/` · `*.iml` | 로그·빌드·IntelliJ 설정 등 |
| (작성 후) `git add .gitignore` → `commit` | ignore 규칙도 버전 관리 |

### 1-h. 준비 확인 〔최초 직후 · 또는 의심될 때〕

| 확인 | 기대 |
|------|------|
| `git status` | `On branch main` … |
| `git log --oneline -5` | 최근 커밋 |
| GitHub 저장소 페이지 · IntelliJ Open | 로컬과 대응 |

→ 준비되면 **2번**.

---

## 2. 최신 main 맞추기 〔매 사이클〕

| Syntax | 의미 | 사용 예 |
|--------|------|---------|
| `git checkout main` / `git switch main` | 공식 브랜치로 | |
| `git pull origin main` | 원격 확정본 받기 <a id="fnref9"></a>[[9]](#fn9) | |

**GitHub:** 브랜치 **main**. Fork면 **Sync fork** 후 로컬 `pull` (upstream을 쓰는 경우 <a id="fnref6"></a>[[6]](#fn6)).

| 보조 | 의미 | 주의 |
|------|------|------|
| `git fetch origin` | 원격 브랜치 정보만 가져오기 | 병합 안 함 |
| `git merge origin/main` | fetch 후 직접 병합 (pull과 유사) | 현재 브랜치가 main일 때 |
| `git reset --hard origin/main` | 강제 일치 <a id="fnref10"></a>[[10]](#fn10) | 미저장 수정 삭제 |
| `git reset --hard <커밋>` | 지정 커밋으로 워킹트리·stage 맞춤 | 공유 main에서는 비권장 · `revert` 선호 |

---

## 3. Feature branch 만들기 〔매 사이클〕

| Syntax | 의미 | 사용 예 |
|--------|------|---------|
| `git checkout -b <이름>` / `git switch -c <이름>` | 새 작업 갈래 생성+이동 <a id="fnref11"></a>[[11]](#fn11) | `git checkout -b feature/add-square` |

**GitHub:** (선택) 브랜치 드롭다운 → **Create branch**. 보통 로컬 생성 후 5번에서 push.

| 보조 / 옵션 | 의미 | 사용 예 |
|-------------|------|---------|
| `git branch` / `git branch -a` | 로컬 / 원격 목록 (`*` = 현재) | |
| `git branch <이름>` | 브랜치만 생성 (이동 안 함) | 이후 `git checkout <이름>` |
| `git checkout <이름>` / `git switch <이름>` | 기존 브랜치로 이동 | |

---

## 4. 수정 → Stage → Commit 〔매 사이클 · 반복 가능〕

| Syntax | 의미 | 사용 예 |
|--------|------|---------|
| (에디터에서 수정) | 예: `Square.java` | IntelliJ |
| `git status` | 변경 확인 <a id="fnref12"></a>[[12]](#fn12) | |
| `git add <파일>` | stage | `git add src/shapes/Square.java` |
| `git commit -m "메시지"` | 로컬 기록 <a id="fnref13"></a>[[13]](#fn13) | `git commit -m "Add Square class"` |

**GitHub:** 로컬 중심. IntelliJ: 체크=`add`, Commit=`commit`.

| 보조 — stage / 차이 / 로그 | 의미 | 사용 예 |
|---------------------------|------|---------|
| `git add .` | 현재 이하 변경 전부 stage | |
| `git diff` | 수정됐지만 아직 stage 안 된 차이 | |
| `git diff --staged` | stage됐지만 아직 commit 안 된 차이 | |
| `git restore --staged <파일>` | stage 취소 (내용 유지) | 현대적 방법 |
| `git reset <파일>` | stage 취소 (치트시트식, 내용 유지) | `git reset Square.java` |
| `git log` / `git log --oneline` | 커밋 히스토리 | |
| `git log --follow <파일>` | 이름 바뀌어도 그 파일 이력 | 리네임 추적 |
| `git log --stat -M` | 통계 + 이동/리네임 힌트 | |
| `git log branchB..branchA` | A에만 있고 B에 없는 커밋 | 브랜치 비교 |
| `git diff branchB...branchA` | A에만 있는 변경 diff | 브랜치 비교 |
| `git show <SHA>` | 특정 커밋/객체 내용 | 해시 일부만 해도 됨 |

| 보조 — 파일 삭제·이동 | 의미 | 사용 예 |
|----------------------|------|---------|
| `git rm <파일>` | 파일 삭제 + 그 삭제를 stage | `git rm Old.java` |
| `git mv <옛경로> <새경로>` | 이동/이름변경 + stage | `git mv a/A.java b/A.java` |

| 보조 — stash (임시 보관) | 의미 | 사용 예 |
|--------------------------|------|---------|
| `git stash` | 수정·stage를 임시 저장 후 워킹트리 정리 | 급히 브랜치 전환 |
| `git stash list` | stash 목록 | |
| `git stash pop` | 가장 위 stash 적용 후 목록에서 제거 | |
| `git stash drop` | 가장 위 stash 버리기 | 적용 없이 삭제 |


## 5. Feature Push 〔매 사이클〕

| Syntax | 의미 | 사용 예 |
|--------|------|---------|
| `git push -u origin <브랜치>` | 원격 업로드 + 추적 <a id="fnref14"></a>[[14]](#fn14) | `git push -u origin feature/add-square` |
| `git push` | (-u 이후) 재업로드 | 추가 커밋 후 |

**GitHub:** **Compare & pull request** 배너 · **Branches**.  
이 시점에도 **main은 그대로** (백업·공유만).

---

## 6. Pull Request · 리뷰 〔매 사이클〕

PR은 Git 명령이 아니라 **GitHub 기능** <a id="fnref15"></a>[[15]](#fn15).

| # | GitHub 메뉴 | 의미 |
|---|-------------|------|
| 1 | **Pull requests → New pull request** | 요청 시작 |
| 2 | base=`main` ← compare=`feature/…` | 합칠 방향 |
| 3 | 제목 · **Reviewers** | 팀원 지정 |
| 4 | **Create pull request** | |
| 5 | **Files changed** → **Review changes** | Comment / Approve / Request changes |
| 6 | **Conversation** | 토론 |

| 선택 CLI | 의미 |
|----------|------|
| `gh pr create` | 터미널에서 PR |

**Checks / Actions**가 있으면 통과 여부 확인 (저장소에 설정된 경우).

---

## 7. 피드백 반영 〔필요할 때 · 같은 사이클〕

| Syntax | 의미 |
|--------|------|
| 수정 → `git add` → `git commit` → `git push` | **같은 PR**에 자동 반영 |

**GitHub:** Conversation · Reply / Resolve.

| 보조 (충돌 시) | 의미 |
|----------------|------|
| `git checkout main` → `git pull` → `git checkout <feature>` → `git merge main` | 최신 main 반영 <a id="fnref16"></a>[[16]](#fn16) |
| `<<<<<<<` 정리 → `add` → `commit` → `push` | 충돌 해결 |
| PR **Resolve conflicts** | 웹에서 간단 충돌 해결 |

| 보조 | 의미 |
|------|------|
| `git rebase main` | 히스토리 재배치 <a id="fnref17"></a>[[17]](#fn17) · 익숙해진 뒤 |

---

## 8. Merge — main 확정본 갱신 〔매 사이클〕

| GitHub | 의미 |
|--------|------|
| **Merge pull request → Confirm merge** | feature → main <a id="fnref18"></a>[[18]](#fn18) |
| (선택) **Delete branch** | 원격 feature 삭제 |

| 선택 CLI | 의미 |
|----------|------|
| `gh pr merge` | 터미널 merge |

| 보조 (웹 대신 로컬) | |
|---------------------|--|
| `git checkout main` → `git pull` → `git pull origin <feature>` → `git push` | Atlassian식 로컬 merge |

| 보조 | 의미 |
|------|------|
| `git merge <브랜치>` | 지정 브랜치 히스토리를 현재 브랜치에 병합 | 로컬에서 feature→main 등 |
| `git revert <커밋>` | main 실수 취소 (새 커밋으로 되돌림) | |

---

## 9. 정리 · 다음 사이클 〔매 사이클〕

| Syntax | 의미 | 사용 예 |
|--------|------|---------|
| `git checkout main` | 공식으로 복귀 | |
| `git pull origin main` | merge된 최신 main | |
| `git branch -d <feature>` | 로컬 feature 삭제 | `git branch -d feature/add-square` |

**GitHub:** Delete branch · **Branches** 정리.  
(선택) **Releases** / tag `v1.0` = 제출·완성 시점 표시.

→ **다음 기능:** 다시 **2번**(main 맞춤)부터.  
→ **새 PC/새 저장소:** **1번**부터.

---

## 단계와 「최초」가 어디에 붙는지

| 단계 | 매 사이클 | 최초·특별 (이미 됐으면 스킵) |
|------|-----------|------------------------------|
| **1** | — | 계정, Git, 저장소, config, **clone 또는 init**, `.gitignore`, SSH, main 보호, 확인 |
| **2–9** | 전부 | Fork면 Sync/upstream (필요할 때) |

**저장소는 언제?** → **1-c** (clone **1-e** 보다 앞).

---

## 각주 (상세)

1. <a id="fn1"></a> `user.name` / `user.email`은 커밋 메타데이터. GitHub **Emails**에 같은 주소가 있어야 프로필에 연결. `--global` = 이 PC의 이 OS 사용자 전체. [↑ 본문으로](#fnref1)
2. <a id="fn2"></a> 저장소 = GitHub上的 프로젝트 상자. 없으면 clone할 URL이 없음. 과제는 Fork 또는 Collaborator가 흔함. [↑ 본문으로](#fnref2)
3. <a id="fn3"></a> README 체크 시 원격에 첫 커밋 생김. 완전 빈 저장소면 로컬 첫 커밋 후 push. [↑ 본문으로](#fnref3)
4. <a id="fn4"></a> `clone` = 원격 복사 + 히스토리 + `origin` 자동. `init` = 현재 폴더에 빈 저장소만 만듦(원격 없음 → 나중에 `remote add`+`push`). 같은 폴더에 둘 다 쓰지 않음. 이미 clone된 폴더는 재clone 말고 `pull`(2번). [↑ 본문으로](#fnref4)
5. <a id="fn5"></a> HTTPS push는 비밀번호 대신 Token / Credential Manager / SSH. IntelliJ가 브라우저 로그인을 띄울 수 있음. [↑ 본문으로](#fnref5)
6. <a id="fn6"></a> Fork: `origin` = 내 fork, `upstream` = 원본. `fetch upstream` → `merge upstream/main` → `push origin main`. [↑ 본문으로](#fnref6)
7. <a id="fn7"></a> SSH는 나중에 해도 됨. 공개키만 GitHub에, 비밀키는 PC에. [↑ 본문으로](#fnref7)
8. <a id="fn8"></a> Branch protection이 있으면 main 실수 push 거절 → feature → PR만 가능. [↑ 본문으로](#fnref8)
9. <a id="fn9"></a> `pull` ≈ fetch + merge. 최신 main에서 feature를 따기 위한 핵심. [↑ 본문으로](#fnref9)
10. <a id="fn10"></a> `reset --hard`는 로컬 변경 삭제 가능. 불안하면 `pull`만. [↑ 본문으로](#fnref10)
11. <a id="fn11"></a> 이름 예: `feature/add-square`. Git상 main과 feature는 동등. “main만 공식”은 팀 규칙. [↑ 본문으로](#fnref11)
12. <a id="fn12"></a> Untracked → (`add`) Staged → (`commit`) Unmodified. Stage = 이번 커밋에 넣을 것만. [↑ 본문으로](#fnref12)
13. <a id="fn13"></a> Commit = 로컬 기록. GitHub 반영은 `push`. 메시지에 무엇을/왜. [↑ 본문으로](#fnref13)
14. <a id="fn14"></a> `-u` 이후 `git push`만. feature push ≠ main 변경. [↑ 본문으로](#fnref14)
15. <a id="fn15"></a> PR = 병합 요청 + 리뷰 공간. 중간 도움 요청에도 사용. [↑ 본문으로](#fnref15)
16. <a id="fn16"></a> 충돌 = 같은 줄 동시 수정. 파일 분담 · 자주 2번으로 예방. [↑ 본문으로](#fnref16)
17. <a id="fn17"></a> Rebase = 히스토리 재작성. 초심자는 `merge`로 충분. 공유 중인 브랜치는 상의 후. [↑ 본문으로](#fnref17)
18. <a id="fn18"></a> Merge 후 main = 새 확정본. Squash/Merge 중 팀에서 하나 통일. [↑ 본문으로](#fnref18)
19. <a id="fn19"></a> `.gitignore`는 저장소별 무시 목록. `core.excludesfile`은 PC 전역 무시 목록. 이미 추적 중인 파일은 ignore에 넣어도 계속 추적됨 → 필요 시 `git rm --cached`. [↑ 본문으로](#fnref19)
