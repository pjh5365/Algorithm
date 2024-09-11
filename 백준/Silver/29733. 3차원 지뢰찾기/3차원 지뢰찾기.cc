#include <bits/stdc++.h>
using namespace std;
int R, C, H;
char mine[100][100][100];
int ret[100][100][100];
string input;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> R >> C >> H;
  for (int i = 0; i < H; i++) {
    for (int j = 0; j < R; j++) {
      cin >> input;
      for (int k = 0; k < C; k++) mine[i][j][k] = input.at(k);
    }
  }
  for (int i = 0; i < H; i++) {
    for (int j = 0; j < R; j++) {
      for (int k = 0; k < C; k++) {
        if (mine[i][j][k] == '*') {
          ret[i][j][k] = -100;
          for (int dx = -1; dx < 2; dx++) {
            for (int dy = -1; dy < 2; dy++) {
              for (int dz = -1; dz < 2; dz++) {
                int x = i + dx;
                int y = j + dy;
                int z = k + dz;
                if (x < 0 || x > H - 1 || y < 0 || y > R - 1 || z < 0 ||
                    z > C - 1)
                  continue;

                if (ret[x][y][z] >= 0 && mine[x][y][z] == '.') {
                  ret[x][y][z]++;
                  ret[x][y][z] %= 10;
                }
              }
            }
          }
        }
      }
    }
  }
  for (int i = 0; i < H; i++) {
    for (int j = 0; j < R; j++) {
      for (int k = 0; k < C; k++) {
        if (ret[i][j][k] == -100)
          cout << '*';
        else
          cout << ret[i][j][k];
      }
      cout << '\n';
    }
  }
}
