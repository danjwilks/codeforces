import sys
import os
from termcolor import colored
import re

DIRECTORY = '/Users/officium/Documents/codeforces/'
TEMPLATE_FILE_CONTENTS = '''import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class {} {{
    public static void main(String[] args) {{
        
        FastReader fr = new FastReader();
        


    }}


    /** HELPER */

    static class FastReader {{
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {{
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }}

        int[] nextLineAsIntArray(int n) {{
            int[] result = new int[n];

            for (int i = 0; i < n; i++) {{
                result[i] = nextInt();
            }}
            return result;
        }}

        long[] nextLineAsLongArray(int n) {{
            long[] result = new long[n];

            for (int i = 0; i < n; i++) {{
                result[i] = nextLong();
            }}

            return result;
        }}
 
        String next()
        {{
            while (st == null || !st.hasMoreElements()) {{
                try {{
                    st = new StringTokenizer(br.readLine());
                }}
                catch (IOException e) {{
                    e.printStackTrace();
                }}
            }}
            return st.nextToken();
        }}
 
        int nextInt() {{ return Integer.parseInt(next()); }}
 
        long nextLong() {{ return Long.parseLong(next()); }}
 
        double nextDouble()
        {{
            return Double.parseDouble(next());
        }}
 
        String nextLine()
        {{
            String str = "";
            try {{
                str = br.readLine();
            }}
            catch (IOException e) {{
                e.printStackTrace();
            }}
            return str;
        }}
    }}
}}
'''


problem_name_words = sys.argv[1:]

filename = ''

for word in problem_name_words:
    word = re.sub(r'\W+', '', word)
    if (len(word) == 0):
        continue

    filename += (word.capitalize())



path = DIRECTORY + filename + '.java'
file_contents = TEMPLATE_FILE_CONTENTS.format(filename)

print()

if os.path.exists(path):
    print(colored("ERROR: File found with name '{}'.".format(path), 'red'))
else:
    with open(path, 'w') as f:
        f.write(file_contents)
        print(colored("SUCCESS: File with name '{}' created.".format(path), 'green'))    
print()
