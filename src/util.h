#include <fstream>
#include <filesystem>

using namespace std;

namespace util {
   inline vector<string> loadInputFile(const string& fileName) {
      vector<string> data;
      fstream inputStream;

      inputStream.open(filesystem::path("data") / fileName, ios::in);
      if (!inputStream.is_open())
         throw("file is not open");

      string line;
      while(getline(inputStream, line))
         data.push_back(line);

      inputStream.close();
      return data;
   }

   inline vector<string> split(const string& delimitedString, const char delimiter) {
      istringstream inputStream(delimitedString);
      string token;
      vector<string> result;
      while(getline(inputStream, token, delimiter))
         if(token.size() != 0)
            result.push_back(token);

      return result;
   }

   inline string trim(const string& whitespacedString, const string& whitespace = " \t")
   {
      const auto begin = whitespacedString.find_first_not_of(whitespace);
      if (begin == std::string::npos)
         return string();

      const auto end = whitespacedString.find_last_not_of(whitespace);
      return whitespacedString.substr(begin, end - begin + 1);
   }

   inline constexpr ushort numberOfDigits(const uint number)  
   {  
      return (number < 10 ? 1 :   
         (number < 100 ? 2 :   
         (number < 1000 ? 3 :   
         (number < 10000 ? 4 :   
         (number < 100000 ? 5 :   
         (number < 1000000 ? 6 :   
         (number < 10000000 ? 7 :  
         (number < 100000000 ? 8 :  
         (number < 1000000000 ? 9 :  
         10)))))))));  
   }
}
