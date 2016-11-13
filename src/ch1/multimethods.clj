(ns ch1.multimethods
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

(defmulti cost (fn [entity store] (class entity)))

(defmethod cost Recipe [recipe store]
  (reduce +$ zero-dollars
          (map #(cost % store) (:ingredients recipe))))

(defmethod cost Ingredient [ingredient store]
  (cost-of store ingredient))
