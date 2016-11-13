(ns ch1.protocols
  (:require [ch1.money :refer :all]
            [schema.core :as s]))

(s/defrecord Ingredient
    [name     :- s/Str
     quantity :- s/Int
     unit     :- s/Keyword])

(s/defrecord Recipe
    [name        :- s/Str
     description :- s/Str
     ingredients :- [Ingredient]
     steps       :- [s/Str]
     servings    :- s/Int])

(defrecord Store [,,,])

(defn cost-of [store ingredient] ,,,)

(defprotocol Cost
  (cost [entity store]))

(extend-protocol Cost
  Recipe
  (cost [recipe store]
    (reduce +$ zero-dollars
            (map #(cost % store) (:ingredients recipe))))
  
  Ingredient
  (cost [ingredient store]
    (cost-of store ingredient)))
