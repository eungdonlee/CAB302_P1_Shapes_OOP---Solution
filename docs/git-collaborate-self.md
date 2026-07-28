# 두 GitHub 계정으로 협업 연습 (PC-A / PC-B)

PC-B를 **eungdon-cyber 전용**으로 쓰면 됩니다. 브라우저·Git 자격 증명·IDE(GitHub 계정)·`git config`를 전부 그 계정에 맞추면 됩니다.

가정 예:

| PC | GitHub 계정 | 역할 |
|----|-------------|------|
| PC-A | eungdonlee | 저장소 owner · 리뷰 |
| PC-B | eungdon-cyber | Collaborator · feature PR |

주 IDE: **IntelliJ** 또는 **VS Code** (둘 다 Git 협업 가능).

---

## 1. 저장소 권한 (PC-A / eungdonlee 쪽에서)

프로젝트 소유 계정(`eungdonlee`)에서:

1. 저장소 → **Settings → Collaborators**
2. **eungdon-cyber** 초대 → PC-B에서 수락

(또는 cyber가 **Fork** 후 PR — 연습엔 Collaborator가 더 단순합니다.)

---

## 2. PC-B 브라우저

1. GitHub에서 **Sign out** (`eungdonlee`)
2. **eungdon-cyber**로 Sign in
3. 초대 메일/알림에서 Collaborator **Accept**

같은 브라우저에 계정이 섞이면 다시 lee가 붙습니다. 연습용으로 Chrome **프로필을 cyber 전용**으로 두는 것도 좋습니다.

---

## 3. PC-B Git 신원 (커밋에 찍히는 이름)

IntelliJ / VS Code **터미널** 또는 PowerShell:

```powershell
git config --global user.name "eungdon-cyber"
git config --global user.email "cyber계정에등록된이메일@..."
git config --global -l
```

이메일은 GitHub → **Settings → Emails**에 있는 주소와 맞추세요.

---

## 4. PC-B 자격 증명 (가장 중요)

Windows가 예전에 **eungdonlee** 토큰을 저장해 두면, push가 계속 lee로 나갑니다.

1. **제어판 → 자격 증명 관리자 → Windows 자격 증명**
2. `git:https://github.com` / `github.com` 항목 **제거**
3. 다음 `git push`/`pull` 때 **eungdon-cyber**로 로그인 또는 [PAT](https://github.com/settings/tokens) 입력

### IDE에서 GitHub 계정 맞추기

**IntelliJ**

- **Settings → Version Control → GitHub**
- `eungdonlee` 계정 있으면 **Remove**
- **Add account…** → **eungdon-cyber** 로그인 (Log In via GitHub)

**VS Code**

- 확장 **GitHub Pull Requests** (및 필요 시 **GitHub Authentication**) 설치 권장
- 왼쪽 하단 계정 아이콘 / **Accounts** → GitHub **Sign out** (lee) 후 **Sign in** (cyber)
- 또는 Command Palette (`Ctrl+Shift+P`) → `GitHub: Sign out` / `GitHub: Sign in`
- Source Control에서 Push할 때 cyber로 인증되는지 확인

---

## 5. PC-B에서 프로젝트 받기

Collaborator인 경우 (같은 repo URL):

```powershell
cd E:\원하는\경로
git clone https://github.com/eungdonlee/CAB302_P1_Shapes_OOP---Solution.git
cd CAB302_P1_Shapes_OOP---Solution
```

| IDE | 폴더 열기 |
|-----|-----------|
| **IntelliJ** | **File → Open** → 그 폴더 |
| **VS Code** | **File → Open Folder** → 그 폴더 |

---

## 6. 연습 흐름 (PC-B = cyber)

터미널:

```powershell
git checkout main
git pull origin main
git checkout -b feature/from-cyber
# 수정
git add <파일>
git commit -m "..."
git push -u origin feature/from-cyber
```

또는 GUI:

| 단계 | IntelliJ | VS Code |
|------|----------|---------|
| 브랜치 생성 | 우측 하단 브랜치 → New Branch | 좌측 하단 브랜치명 → Create new branch… |
| stage / commit | Commit 창 체크 + Commit | **Source Control** `+` + Commit |
| push | **Git → Push** | Source Control **… → Push** |

브라우저(cyber) → **Pull request** → base `main` ← compare `feature/from-cyber`  
(또는 VS Code **GitHub Pull Requests** 확장에서 Create Pull Request)

PC-A(lee)에서 Review / Approve / Merge.

---

## 한눈에

| 항목 | PC-A | PC-B |
|------|------|------|
| GitHub 로그인 | eungdonlee | eungdon-cyber |
| `user.name` / `email` | lee | cyber |
| Windows / IDE 자격 증명 | lee | cyber만 |
| IDE | IntelliJ 또는 VS Code | IntelliJ 또는 VS Code |
| 역할 | 저장소 owner · 리뷰 | Collaborator · feature PR |

**정리:** PC-B는 lee 로그아웃 → cyber 로그인 → 자격 증명 삭제 후 cyber로 재인증 → Collaborator 초대 수락 → clone → feature branch → PR.
