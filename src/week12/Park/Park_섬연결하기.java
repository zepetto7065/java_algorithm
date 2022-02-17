package week12.Park;

import java.util.Arrays;
import java.util.Comparator;

public class Park_섬연결하기 {

    public static void main(String[] args) {
        System.out.println(solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));
    }

    static int[] kruskalArray;


    /**
     * n개의 섬 사이에 다리를 건설하는 비용(costs)이 주어질 때, 최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들 때 필요한 최소 비용을 return
     * 섬의 개수 n은 1 이상 100 이하입니다.
     * costs의 길이는 ((n-1) * n) / 2이하입니다.
     * 임의의 i에 대해, costs[i][0] 와 costs[i] [1]에는 다리가 연결되는 두 섬의 번호가 들어있고,
     * costs[i] [2]에는 이 두 섬을 연결하는 다리를 건설할 때 드는 비용입니다.
     * 같은 연결은 두 번 주어지지 않습니다. 또한 순서가 바뀌더라도 같은 연결로 봅니다.
     * 즉 0과 1 사이를 연결하는 비용이 주어졌을 때, 1과 0의 비용이 주어지지 않습니다.
     * 모든 섬 사이의 다리 건설 비용이 주어지지 않습니다. 이 경우, 두 섬 사이의 건설이 불가능한 것으로 봅니다.
     * 연결할 수 없는 섬은 주어지지 않습니다.
     **/
    public static int solution(int n, int[][] costs) {
        int answer = 0;

        // costs를 가중치를 기준으로 오름차순 정렬
        Arrays.sort(costs, Comparator.comparingInt((int[] o) -> o[2]));
        // Arrays.sort(costs, (int[] o1, int[] o2) -> o1[2] - o2[2]);  두개 결과 동일

        // Kruskal Algorithm을 사용하기위해, 배열을 선언한다.
        // index는 섬의 번호이고, 값은 부모 섬의 번호

        kruskalArray = new int[n];

        // index를 값으로 초기화
        for (int i = 0; i < n; i++) {
            kruskalArray[i] = i;
        }

        for (int[] node : costs) {
            // 다리를 연결하는 섬의 부모노드의 값을 가져온다.
            int startParent = findParentNode(node[0]);
            int endParent = findParentNode(node[1]);

            if (startParent != endParent) {
                answer += node[2];
                // 두 섬을 연결
                kruskalArray[endParent] = startParent;
            }
        }

        // 0부터 시작.. 작은 값쪽으로 타고 들어간다.
        return answer;
    }

    // 노드(index)를 받아서 연결된 부모노드(index)를 반환
    private static int findParentNode(int node) {
        if (kruskalArray[node] == node) {
            return node;
        }
        // 재귀를 통해, 가장 처음 부모노드의 값을 가져온다.
        kruskalArray[node] = findParentNode(kruskalArray[node]);

        return kruskalArray[node];
    }
}