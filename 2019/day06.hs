import qualified Data.Map.Strict as M 
import           Data.List 
import           Data.Maybe

main :: IO ()
main = do
  file <- readFile "input6.txt" 
  let solution1 = (show . solve  . parse . lines) file 
      solution2 = (show . solve' . parse . lines) file
  putStrLn $ "Solution 1: " ++ solution1
  putStrLn $ "Solution 2: " ++ solution2

solve :: M.Map String String -> Int
solve x =  sum $ map (length . findFather [] x) $ M.keys x

solve' :: M.Map String String -> Int
solve' x = santaDis + myDis
  where
  santaPath   = reverse $ findFather [] x "SAN"
  myPath      = reverse $ findFather [] x "YOU"
  firstCommon = head [ x | x <- santaPath, y <- myPath, x == y ]

  santaDis = fromJust $ firstCommon `elemIndex` santaPath
  myDis    = fromJust $ firstCommon `elemIndex` myPath

findFather :: [String] -> M.Map String String -> String -> [String]
findFather l _ "COM" = l 
findFather l m val   = findFather (nextFather:l) m nextFather 
 where
   nextFather = m M.! val

parse :: [String] -> M.Map String String
parse ls = M.fromList $ map (\x -> (splitted x !! 1, splitted x !! 0)) ls
  where
    splitted = split ')'


split :: Char -> String -> [String]
split x [] = [""]
split x (c:cs)
  | c == x  = "" : rest
  | otherwise = (c : head rest) : tail rest
    where rest = split x cs
